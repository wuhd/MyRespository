package ResChain;

public class DepartmentManager extends Handler {

	protected DepartmentManager(int maxDay) {
		super(maxDay);
	}

	@Override
	protected void reply(int day) {
		System.out.println(day+"��٣����ž���ֱ������ͨ��");
	}

}
