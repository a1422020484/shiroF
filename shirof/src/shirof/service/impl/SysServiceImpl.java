package shirof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shirof.mapper.SysUserMapper;
import shirof.po.ActiveUser;
import shirof.po.SysUser;
import shirof.po.SysUserExample;
import shirof.service.SysService;
import shirof.util.MD5;
import shirof.util.exception.UserException;

/**
 * @author yang
 * 认证和授权的服务接口
 */
public class SysServiceImpl implements SysService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public ActiveUser authenticat(String userCode, String password) throws Exception {
		// TODO Auto-generated method stub
		SysUser sysUser = this.findSysUserByUserCode(userCode);
		if(sysUser == null){
			throw new UserException("账号不存在！");
		}
		//数据库密码（md5）
		String password_db = sysUser.getPassword();
		//对页面输入密码进行加密
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if(!password_input_md5.equalsIgnoreCase(password_db)){
			throw new UserException("密码输入错误！");
		}
		//获得用户信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUsercode(userCode);
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsername(sysUser.getUsername());
		return activeUser;
	}

	
	//
	public SysUser findSysUserByUserCode(String userCode) throws Exception{
		
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(userCode);
		
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
}
