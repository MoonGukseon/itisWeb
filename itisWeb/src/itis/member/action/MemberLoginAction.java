package itis.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itis.member.action.ActionForward;
import member.db.MemberBean;
import member.db.MemberDAO;

public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
			ActionForward forward = new ActionForward();
			
			HttpSession session = request.getSession();
			MemberBean mBean = new MemberBean();
			MemberDAO mMgr = new MemberDAO();
			
			int result=-1;
			
			mBean.setMEMBER_ID(request.getParameter("MEMBER_ID"));
			mBean.setMEMBER_PW(request.getParameter("MEMBER_PW"));
			result=mMgr.isMember(mBean);
			
			if(result==0){
				response.setContentType("text/html;charset=euc-kr");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.');");
				out.println("location.href='./MemberLogin.me';");
				out.println("</script>");
				out.close();
				return null;
			} else if(result==1) {
				response.setContentType("text/html;charset=euc-kr");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디가 존재하지 않습니다.');");
				out.println("location.href='./MemberLogin.me';");
				out.println("</script>");
				out.close();
				return null;
			}
			
			session.setAttribute("MEMBER_ID", mBean.getMEMBER_ID());
			
			forward.setRedirect(true);
			forward.setPath("MemberListAction.me");
			return forward;
	}
	
}
