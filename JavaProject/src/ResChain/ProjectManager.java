package ResChain;

public class ProjectManager extends Handler {

	protected ProjectManager(int maxDay) {
		super(maxDay);
	}

	@Override
	protected void reply(int day) {
		System.out.println(day+"��٣���Ŀ����ֱ������ͨ��");
	}

}
