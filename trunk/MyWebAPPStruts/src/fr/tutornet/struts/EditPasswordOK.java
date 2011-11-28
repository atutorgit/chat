package fr.tutornet.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * Fake ActionForm class, used only to return a confirmation message
 * @author root
 *
 */
public class EditPasswordOK extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors result = new ActionErrors();

		result.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"confirm.editPassword"));

		return result;
	}

}
