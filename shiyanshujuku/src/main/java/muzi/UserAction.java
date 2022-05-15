package muzi;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserAction extends DispatchAction {
    @Override
    protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List userlist = new ArrayList();
        UserDao userDao = new UserDao();
        userlist = userDao.findAllUser();
        request.setAttribute("userlist",userlist);

        return mapping.findForward("listAllUser");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List userlist = new ArrayList();
        UserActionForm uaf = (UserActionForm)form;
        User user = new User();
        UserDao userDao = new UserDao();
        BeanUtils.copyProperties(user, uaf);
        userDao.addUser(user);
        userlist = userDao.findAllUser();
        request.setAttribute("userlist",userlist);

        return mapping.findForward("add_success");
    }

    public ActionForward finduser(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = new User();
        UserDao userDao = new UserDao();
        user = userDao.findUserbyID(user_id);
        request.setAttribute("user",user);
        return mapping.findForward("find_success");
    }

    public ActionForward updateuser(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserActionForm uaf = (UserActionForm) form;
        User user = new User();
        UserDao userDao = new UserDao();
        BeanUtils.copyProperties(user, uaf);
        userDao.updateuser(user);
        return mapping.findForward("update_success");
    }
    public ActionForward deluser(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int userid = Integer.parseInt(request.getParameter("user_id"));
        UserDao userDao = new UserDao();
        userDao.deluserByID(userid);
        return mapping.findForward("delete_success");
    }
}
