package shirof.service;

import shirof.po.ActiveUser;
import shirof.po.SysUser;

public interface SysService {
	
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
	public SysUser findSysUserByUserCode(String userCode) throws Exception;
	
}
