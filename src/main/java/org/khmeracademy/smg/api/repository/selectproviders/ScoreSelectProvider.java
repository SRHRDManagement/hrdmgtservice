package org.khmeracademy.smg.api.repository.selectproviders;

import java.util.ArrayList;
import java.util.Map;

import org.khmeracademy.smg.api.model.Subject;

public class ScoreSelectProvider {
	
	private ArrayList<Subject> subjects;

	public String getReport(Map<String, Object> map){
		subjects = (ArrayList<Subject>)map.get("subjects");
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("SELECT stu.stu_firstname, stu.stu_lastname, stu.stu_gender, cl.cla_name, ");
		
		for(Subject subject: subjects){
			strBuilder.append("MAX(CASE WHEN sc.sub_id="+subject.getSub_id() +"THEN sc.sco_score ELSE NULL END)*"+subject.getSub_percent()+" AS "+ subject.getSub_name()+", ");
		}
		
			strBuilder.append("Sum(abs.abs_score)/(SELECT COUNT(stu_id) FROM smg_score WHERE stu_id=(SELECT stu_id FROM smg_score LIMIT 1)) AS attendance "
			+ "FROM smg_student stu "
			+ "INNER JOIN smg_studentenroll se ON se.stu_id = stu.stu_id "
			+ "LEFT JOIN smg_score sc ON sc.stu_id = se.stu_id AND sc.mon_id=#{mon_id} "
			+ "INNER JOIN smg_class cl ON se.cla_id =cl.cla_id "
			+ "LEFT JOIN smg_attendance att ON att.stu_id = se.stu_id AND att.mon_id=#{mon_id} "
			+ "LEFT JOIN smg_absent_type abs ON att.abs_id = abs.abs_id "
			+ "LEFT JOIN smg_subject sub ON sc.sub_id = sub.sub_id "
			+ "GROUP BY stu.stu_firstname, stu.stu_lastname, stu.stu_gender, cl.cla_name, att.stu_id");
			
			return strBuilder.toString();
	}
}
