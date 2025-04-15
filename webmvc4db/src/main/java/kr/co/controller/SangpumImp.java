package kr.co.controller;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.model.DataDto;
import kr.co.model.SangpumProcess;

public class SangpumImp implements CommandInter {
@Override
public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
	SangpumProcess sangpumProcess = new SangpumProcess();
	ArrayList<DataDto> list = (ArrayList<DataDto>) sangpumProcess.selectSangpumAll();
	request.setAttribute("datas", list);
	return "sanglist.jsp";
	}
}