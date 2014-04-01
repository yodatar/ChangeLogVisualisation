package sk.AjaxRequestServlet;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.ApplicationStateDto;
import com.gratex.perconik.astrcs.iactivitysvc.RunningApplicationsListDto;
import com.gratex.perconik.astrcs.iactivitysvc.StateDto;
import sk.BusinessLogic.DatabaseRequestHandlers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:16
 */


public class GetActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DatabaseRequestHandlers databaseRequestHandlers = new DatabaseRequestHandlers();
		List<ActivityDto> activityDtoList = databaseRequestHandlers.getActivity();
		List list = new LinkedList();


		StateDto state = activityDtoList.get(0).getStates().getKeyboardStateDtoOrMouseStateDtoOrRunningApplicationsListDto().get(0);
		System.out.println(state.getClass().getName());
		RunningApplicationsListDto runningApplicationsListDto = (RunningApplicationsListDto) state;
		for (ApplicationStateDto applicationStateDto : runningApplicationsListDto.getItems().getApplicationStateDto()) {
			list.add(applicationStateDto.getApplicationRun().getApplicationName());
		}

		PrintWriter out = response.getWriter();
		out.print(list);
	}
}