package priv.guochun.psmc.system.framework.cache;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * spring cache + redis缓存实现类
 */
public class RedisCache implements Cache
{
    protected static final Logger logger  = LoggerFactory.getLogger(RedisCache.class);
    private RedisTemplate<String, Object> redisTemplate;
    private String name;

    @Override
    public void clear() {
        logger.debug("-------緩存清理------");
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    @Override
    public void evict(Object key) {
        logger.debug("-------緩存刪除------");
        final String keyf=key.toString();
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(keyf.getBytes());
            }

        });

    }

    @Override
    public ValueWrapper get(Object key) {
        logger.debug("------redis缓存获取-------"+key.toString());
        try{
            final String keyf = key.toString();
            Object object = null;
            object = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] key = keyf.getBytes();
                    byte[] value = connection.get(key);
                    if (value == null) {
                        logger.debug("------redis缓存不存在-------");
                        return null;
                    }
                    return SerializationUtils.deserialize(value);
                }
            });
            ValueWrapper obj=(object != null ? new SimpleValueWrapper(object) : null);
            return obj;
        }catch(DataAccessException e){
            logger.debug("------redis缓存获取失败-------"+e.getMessage());
        }
        return  null;
    }

    @Override
    public void put(Object key, Object value) {
        logger.debug("-------redis加入缓存------");
        final String keyString = key.toString();
        final Object valuef = value;
        final long liveTime = 86400;
        try{
            redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] keyb = keyString.getBytes();
                    byte[] valueb = SerializationUtils.serialize((Serializable) valuef);
                    connection.set(keyb, valueb);
                    if (liveTime > 0) {
                        connection.expire(keyb, liveTime);
                    }
                    return 1L;
                }
            });
        }catch(DataAccessException e){
            logger.debug("-------redis加入缓存失败------"+e.getMessage());
        }

    }

    @Override
    public <T> T get(Object arg0, Class<T> arg1) {
        ValueWrapper obj = get(arg0.toString());
        return  obj !=null?(T)obj.get():null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return (T) get(o.toString()).get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
        return null;
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }




}
