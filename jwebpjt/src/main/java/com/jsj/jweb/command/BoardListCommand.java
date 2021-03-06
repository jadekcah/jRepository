package com.jsj.jweb.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.jsj.jweb.dao.BoardDao;
import com.jsj.jweb.dto.BoardDto;

public class BoardListCommand implements JCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
	}

}
