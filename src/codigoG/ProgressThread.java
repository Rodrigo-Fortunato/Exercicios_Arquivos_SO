package codigoG;

import java.io.File;

public class ProgressThread extends Thread {

	public ProgressThread() {
	}

	@Override
	public void run() {
		File source = new File("D:\\Programação\\Java\\", "train.csv");
		File target = new File("D:\\Programação\\Java\\", "backup.csv");
		long sizeSource = source.length();
		long sizeTarget = target.length();
		while (sizeTarget < sizeSource) {
			sizeTarget = target.length();
			float progress = ((float) sizeTarget / sizeSource) * 100;
			System.out.printf("%.2f%%\n", progress);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
