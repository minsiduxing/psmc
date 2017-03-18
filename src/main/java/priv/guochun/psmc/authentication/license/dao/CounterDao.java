package priv.guochun.psmc.authentication.license.dao;

public interface CounterDao {
	public void setCount(int seconds);

	public int getCount();

	/**
	 * @return
	 * @Description: 时间自减
	 */
	public int decCount();
}
