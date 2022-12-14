package ConsoleProject1;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter setter and toString
@NoArgsConstructor
@AllArgsConstructor// ZealousAcademy obj=new ZealousAcademy(String studentName,......)
public class ZealousAcademy implements Comparable<ZealousAcademy>,Serializable
{
	private String studentName;
	private String studentTechnology;
	private String studentIncharge;
	private int studentMemberscount;
	private double studentClasstiming;
	private double studentCourseprice;
	public int compareTo(ZealousAcademy o)
	{
		return this.studentName.compareTo(o.studentName);
	}

}
