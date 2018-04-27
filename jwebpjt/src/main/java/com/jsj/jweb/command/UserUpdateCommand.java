package com.jsj.jweb.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.jsj.jweb.dao.UserDao;
import com.jsj.jweb.dto.UserDto;
import com.jsj.jweb.util.MessageToHash;

public class UserUpdateCommand implements JCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		UserDto dto = (UserDto) map.get("dto");
		
		if(dto.getPw() != null) {
			MessageToHash toHash = new MessageToHash(dto.getPw());
			toHash.toSHA256();
			
			dto.setPw(toHash.getHashed());
		}
		
		UserDao dao = new UserDao();
		
		dao.updateProfile(dto, dto.getUpdateFields());
	}
	
}
