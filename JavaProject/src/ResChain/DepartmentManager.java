package ResChain;

public class DepartmentManager extends Handler {

	protected DepartmentManager(int maxDay) {
		super(maxDay);
	}

	@Override
	protected void reply(int day) {
		System.out.println(day+"天假，部门经理直接审批通过");
	}

}
