package priv.guochun.psmc.authentication.license.sevice;

public interface LicenseReaderService {

	public boolean verify(String pathname);

	public void work();
}
