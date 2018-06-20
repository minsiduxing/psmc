package priv.guochun.psmc.system.common.vcode.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.common.vcode.dao.TabVerificationCodeMapper;
import priv.guochun.psmc.system.common.vcode.factory.VerificationCodeFactory;
import priv.guochun.psmc.system.common.vcode.model.TabVerificationCode;
import priv.guochun.psmc.system.common.vcode.model.TabVerificationCodeExample;
import priv.guochun.psmc.system.common.vcode.model.TabVerificationCodeExample.Criteria;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.VerificationCodeStateEnum;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.TimestampUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;

/**
 * 验证码实现类
 * @author guochun
 *
 */
public class VerificationCodeServiceImpl implements VerificationCodeService {

	
	private SqlSession sqlSession;
	
	//验证码超时时间（分钟）
	private long effectiveTime = 5;
	
	private String codeNotExsits = "验证码不存在!";
	private String codeBeUsedWarn = "验证码已使用或已失效,请重新获取!";
	private String codeBeOverDue = "验证码已过期,请重新获取!";
	
	protected static final  Logger logger  = LoggerFactory.getLogger(VerificationCodeServiceImpl.class);
	
	@Override
	public TabVerificationCode createCode(long type,String phone) {
		String code = null;
		TabVerificationCodeMapper mapper = sqlSession.getMapper(TabVerificationCodeMapper.class);
		TabVerificationCodeExample example = new TabVerificationCodeExample();
		Criteria ct = example.createCriteria();
		ct.andPhoneEqualTo(phone);
		ct.andTypeEqualTo(type);
		ct.andStateEqualTo(VerificationCodeStateEnum.NOT_USE.getValue());
		List<TabVerificationCode>  list = mapper.selectByExample(example);
		if(list != null && list.size() > 0){ //如果存在未使用的验证码,则优先使用
			TabVerificationCode vcode = list.get(0);
			Date ctime = vcode.getCreateTime();
			int effectiveTime = vcode.getEffectiveTime().intValue();
			Date ctimeLast = DateUtil.getDateByAfterMin(ctime, effectiveTime);
			
			if(DateUtil.getCurrentDateTime()>= ctimeLast.getTime()){
				logger.debug("未使用的验证码已超期，将该验证码设置为超期");
				vcode.setState(VerificationCodeStateEnum.BE_OVERDUE.getValue());
				mapper.updateByPrimaryKey(vcode);
			}else{
				vcode.setCreateTime(new Date());
				mapper.updateByPrimaryKey(vcode);
				return vcode;
			}
				
		}
		
		if(code == null || "".equals(code)){
			code = VerificationCodeFactory.getInstance().getCode();
		}
		
		TabVerificationCode record = new TabVerificationCode();
		record.setCode(code);
		record.setUuid(UUIDGenerator.createUUID());
		record.setCreateTime(TimestampUtil.createCurTimestamp());
		record.setState(VerificationCodeStateEnum.NOT_USE.getValue());
		record.setType(type);
		record.setEffectiveTime(effectiveTime);
		record.setPhone(phone);
		mapper.insert(record);
		
		return record;
	}
	

	@Override
	public MsgModel validateCode(String code, long type) {
		return validateCode(code,type,VerificationCodeStateEnum.BE_USED.getValue());
	}
	
	
	@Override
	public MsgModel validateCode(String code, long type,Long state) {
		TabVerificationCodeMapper mapper = sqlSession.getMapper(TabVerificationCodeMapper.class);
		TabVerificationCodeExample example = new TabVerificationCodeExample();
		Criteria ct = example.createCriteria();
		ct.andCodeEqualTo(code);
		ct.andTypeEqualTo(type);
		List<TabVerificationCode>  list = mapper.selectByExample(example);
		if(list !=null && list.size()>0){
			TabVerificationCode vcode =list.get(0);
			if(vcode.getState().longValue() == VerificationCodeStateEnum.NOT_USE.getValue().longValue()){
				//如果状态是未使用，则判断是否在有效期内
				Date ctime = vcode.getCreateTime();
				int effectiveTime = vcode.getEffectiveTime().intValue();
				Date ctimeLast = DateUtil.getDateByAfterMin(ctime, effectiveTime);
				
				if(DateUtil.getCurrentDateTime()>= ctimeLast.getTime()){
					vcode.setState(VerificationCodeStateEnum.BE_OVERDUE.getValue());
					mapper.updateByPrimaryKey(vcode);
					return MsgModel.buildDefaultError(codeBeOverDue);
				}
				
				if(state != null)
					vcode.setState(state.longValue());
				
				mapper.updateByPrimaryKey(vcode);
				return MsgModel.buildDefaultSuccess(code);
				
			}else
				return MsgModel.buildDefaultError(codeBeUsedWarn);
		}else{
			return MsgModel.buildDefaultError(codeNotExsits);
		}
	}
	
	public void deleteCode(String uuid){
		TabVerificationCodeMapper mapper = sqlSession.getMapper(TabVerificationCodeMapper.class);
		mapper.deleteByPrimaryKey(uuid);
	}


	public SqlSession getSqlSession() {
		return sqlSession;
	}


	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	
}
