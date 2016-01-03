package itis.member.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itis.member.action.ActionForward;
import member.db.MemberDAO;

public class MemberListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
			ActionForward forward = new ActionForward();
			
			HttpSession session=request.getSession();
			MemberDAO memberdao = new MemberDAO();
			
			List memberlist=new ArrayList();
			
			String id=(String)session.getAttribute("MEMBER_ID");
			if(id==null){
				forward.setRedirect(true);
				forward.setPath("./MemberLogin.me");
				return forward;
			}  
			
			memberlist=memberdao.getMemberList();
			if(memberlist==null){
				System.out.println("ȸ�� ��� �б� ����");
				return null;
			}
			
			request.setAttribute("memberlist", memberlist);
			forward.setRedirect(false);
			forward.setPath("./member/member_list.jsp");
			return forward;
	}

}
