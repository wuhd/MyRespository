package ResChain;

public class GeneralManager extends Handler {

	protected GeneralManager(int maxDay) {
		super(maxDay);
	}

	@Override
	protected void reply(int day) {
		System.out.println(day+"��٣�����ֱ������ͨ��");
	}

}
