package sk.Servlets;

import com.gratex.perconik.astrcs.iactivitysvc.ActivityDto;
import com.gratex.perconik.astrcs.iactivitysvc.EventDto;
import com.gratex.perconik.astrcs.iactivitysvc.IdeCodeOperationDto;
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
		List<ActivityDto> activityDtoList = databaseRequestHandlers.getActivities();
		List list = new LinkedList();
		int myClassCounter = 0,allClassCounter = 0;

		for(ActivityDto activityDto : activityDtoList) {
			list.add(activityDto.getStartTime() + " - " + activityDto.getEndTime());
			for (EventDto eventDto : activityDto.getEvents().getOneNoteNavigateDtoOrOneNoteViewChangeDtoOrLyncStatusChangeDto()) {
				allClassCounter++;
				if(IdeCodeOperationDto.class.isInstance(eventDto)){
					myClassCounter++;
					IdeCodeOperationDto dto = (IdeCodeOperationDto)eventDto;
					list.add(dto.getDocument().getPath());
					list.add(dto.getCode());
					list.add(dto.getTime());
					list.add(dto.getOperationType());
					list.add(dto.getDocument().getChangesetIdInRcs());
				}
				/*
				if(IdeSlnPrjEventDto.class.isInstance(eventDto)){
					IdeSlnPrjEventDto dto = (IdeSlnPrjEventDto)eventDto;
					list.add(dto.getTime());
					list.add(dto.getSolutionName());
				}
				*/
				list.add("<br/>");
			}
			list.add("<br/><br/>");

			/*	if(IdeCodeElementEventDto.class.isInstance(eventDto)) {
					list.add(activityDto.getWorkstation());
					list.add(activityDto.getStartTime().toString());
					list.add(activityDto.getEndTime().toString());
					list.add("<br/>");

					IdeCodeElementEventDto ideCodeElementEventDto = (IdeCodeElementEventDto) eventDto;
					list.add(ideCodeElementEventDto.getEventType().value());
					list.add(ideCodeElementEventDto.getElementType().toString());
				}
			}

			for (StateDto stateDto : activityDto.getStates().getKeyboardStateDtoOrMouseStateDtoOrRunningApplicationsListDto()) {
				if(RunningApplicationsListDto.class.isInstance(stateDto)) {
					RunningApplicationsListDto runningApplicationsListDto = (RunningApplicationsListDto) stateDto;
					for (ApplicationStateDto applicationStateDto : runningApplicationsListDto.getItems().getApplicationStateDto()) {
						list.add(applicationStateDto.getApplicationRun().getApplicationName());
					}
				}
			}
			*/
		}

		list.add("Activities: "+ list.size());
		list.add("AllClasses: "+ allClassCounter);
		list.add("myClasses: "+ myClassCounter);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(list);
	}
}