package itis.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itis.member.action.ActionForward;
import member.db.MemberBean;
import member.db.MemberDAO;

public class MemberJoinAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
			request.setCharacterEncoding("euc-kr");
			
			ActionForward forward = new ActionForward();
			
			MemberBean mBean = new MemberBean();
			MemberDAO mMgr = new MemberDAO();
			
			boolean result=false;
			
			mBean.setMEMBER_ID(request.getParameter("MEMBER_ID"));
			mBean.setMEMBER_PW(request.getParameter("MEMBER_PW"));
			mBean.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
			mBean.setMEMBER_AGE(Integer.parseInt(request.getParameter("MEMBER_AGE")));
			mBean.setMEMBER_SEX(request.getParameter("MEMBER_SEX"));
			mBean.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL"));
			mBean.setMEMBER_ADDRESS(request.getParameter("MEMBER_ADDRESS"));
			mBean.setMEMBER_PHONE(request.getParameter("MEMBER_PHONE"));
			
			result=mMgr.insertMember(mBean);
			if(result==false){
				System.out.println("회원가입 실패");
				return null;
			}
			
			//회원가입 성공
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
	}

}
