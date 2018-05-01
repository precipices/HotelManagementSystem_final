package com.hms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.AdvanceRoomOrderDao;
import com.hms.dao.RoomDao;
import com.hms.dao.RoomOrderDao;
import com.hms.entity.AdvanceRoomOrder;
import com.hms.entity.RoomOrder;
import com.hms.model.AdvanceRoomOrderModel;
import com.hms.model.RoomModel;
import com.hms.model.RoomOrderModel;
import com.hms.model.SearchRuledRoomModel;

/**
 * Servlet implementation class AssignRoomController
 */
@WebServlet("/AssignRoomController")
public class AssignRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AssignRoomController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<AdvanceRoomOrder> aro = new Vector<AdvanceRoomOrder>();
		aro = (Vector<AdvanceRoomOrder>) request.getSession().getAttribute("aro");
		boolean bl2 = true;
		boolean bl3 = true;
		String roomid = request.getParameter("x");
		String userid = request.getParameter("y");
		String orderid = aro.get(0).getOrderid();
		Date enterdate = aro.get(0).getEnterdate();
		Date leavedate = aro.get(0).getLeavedate();
		RoomOrderModel.SearchAllOrder();
		boolean bl = RoomOrderModel.SearchRuledOrderByOrderId(orderid);
		
		if(request.getParameter("a")!=null&&request.getParameter("b")!=null) {
			Date chooseEnterdate = Date.valueOf(request.getParameter("a"));
			Date chooseleavedate = Date.valueOf(request.getParameter("b"));
			bl2 = enterdate.getTime()-chooseEnterdate.getTime()>=0;
			bl3 = chooseleavedate.getTime()-leavedate.getTime()>=0;			
		}
		
		
		
		if(!bl2||!bl3) {
			String message2 = "无法分配房间，原因为日期问题";
			request.setAttribute("mess2", message2);
			request.setAttribute("RuledRoom", SearchRuledRoomModel.searchRuledRoom(
					request.getSession().getAttribute("RoomType")+"",
					request.getSession().getAttribute("Floor")+"",
					request.getSession().getAttribute("FaceTo")+"",
					Date.valueOf(request.getSession().getAttribute("enterdate")+""),
					Date.valueOf(request.getSession().getAttribute("leavedate")+"")
					));
		}
		else if(!bl) {
			RoomDao.updateRoomStatus(roomid, "有预订");
			if(aro.size()!=0){
				RoomOrder ro = new RoomOrder();
				ro.setOrderid(orderid);
				ro.setRoomid(roomid);
				ro.setIdcard(userid);
				ro.setEnterdate(enterdate);
				ro.setLeavedate(leavedate);
				float charge = (float)((leavedate.getTime()-enterdate.getTime())/24/3600000*(RoomModel.checkPriceByRoomId(roomid)));
				ro.setCharge(charge);
				RoomOrderDao.addRoomOrder(ro);
			}
			request.setAttribute("RuledRoom", SearchRuledRoomModel.searchRuledRoom(
					request.getSession().getAttribute("RoomType")+"",
					request.getSession().getAttribute("Floor")+"",
					request.getSession().getAttribute("FaceTo")+"",
					Date.valueOf(request.getSession().getAttribute("enterdate")+""),
					Date.valueOf(request.getSession().getAttribute("leavedate")+"")
					));
			AdvanceRoomOrderModel.deleteOrderByIdcard(orderid);
		}
		else {
			String message = "该用户已分配房间";
			request.setAttribute("mess", message);
			request.setAttribute("RuledRoom", SearchRuledRoomModel.searchRuledRoom(
					request.getSession().getAttribute("RoomType")+"",
					request.getSession().getAttribute("Floor")+"",
					request.getSession().getAttribute("FaceTo")+"",
					Date.valueOf(request.getSession().getAttribute("enterdate")+""),
					Date.valueOf(request.getSession().getAttribute("leavedate")+"")
					));
		}
		request.getRequestDispatcher("RoomAllocation.jsp").forward(request, response);;
	}
}
