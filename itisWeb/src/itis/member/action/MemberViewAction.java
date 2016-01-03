package itis.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itis.member.action.ActionForward;
import member.db.MemberBean;
import member.db.MemberDAO;

public class MemberViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
			ActionForward forward = new ActionForward();
			
			HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();
			MemberBean member=new MemberBean();
			
			String id=(String)session.getAttribute("MEMBER_ID");
			if(id==null){
				forward.setRedirect(true);
				forward.setPath("./MemberLogin.me");
				return forward;
			} else if(!id.equals("admin")){
				response.setContentType("text/html;charset=euc-kr");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('�����ڰ� �ƴմϴ�.');");
				out.println("location.href='./MemberLogin.me';");
				out.println("</script>");
				out.close();
				return null;
			}
			
			String viewId=request.getParameter("id");
			member=memberdao.getMemberInfo(viewId);
			
			if(member==null){
				System.out.println("ȸ�� ���� ���� ����");
				return null;
			}
			
			request.setAttribute("member", member);
			
			forward.setRedirect(false);
			forward.setPath("./member/member_info.jsp");
			return forward;
	}
}