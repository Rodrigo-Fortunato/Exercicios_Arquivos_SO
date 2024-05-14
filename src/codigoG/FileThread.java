package codigoG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

public class FileThread extends Thread {
	public FileThread() {

	}

	@Override
	public void run() {
		double start_time = System.nanoTime();
		double total_time = 0;
		copyBuffered();
//		copyStream();
		double end_time = System.nanoTime();
		total_time = end_time - start_time;
		System.out.printf("Total: %.2f segundos\n", (total_time / Math.pow(10, 9)));
	}

	private void copyStream() {
		InputStream is = null;
		OutputStream os = null;
		String source = "D:\\Programação\\Java\\train.csv";
		String dest = "D:\\Programação\\Java\\backup.csv";
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[4 * 1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			is.close();
			os.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void copyBuffered() {
		try {
			String inputFileName = "D:\\Programação\\Java\\train.csv";
			String outputFileName = "D:\\Programação\\Java\\backup.csv";
			boolean append = false;
			BufferedReader fr = new BufferedReader(new FileReader(inputFileName));
			BufferedWriter fwr = new BufferedWriter(new FileWriter(outputFileName, append));
			StringBuffer chunk = new StringBuffer();
			String line = fr.readLine();
			int count = 0;

			while (line != null) {
				chunk.append(line);
				line = fr.readLine();
				count++;
				if (count % 100000 == 0) {
					fwr.write(chunk.toString());
					chunk = new StringBuffer();
				}
			}
			fwr.close();
			fr.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
