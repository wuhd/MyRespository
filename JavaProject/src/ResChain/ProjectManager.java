package ResChain;

public class ProjectManager extends Handler {

	protected ProjectManager(int maxDay) {
		super(maxDay);
	}

	@Override
	protected void reply(int day) {
		System.out.println(day+"天假，项目经理直接审批通过");
	}

}
