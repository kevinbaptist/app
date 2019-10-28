package ovh.ladon.lambda_expression;

import ovh.ladon.lambda_expression.implementation.JavaFileFilter;

import java.io.File;
import java.io.FileFilter;

public class Main {
	public static void main(String[] args) {
		//Using a concreet class
		JavaFileFilter fileFilter = new JavaFileFilter();
		File dir = new File("d:/tmp");
		final File[] javaFiles1 = dir.listFiles(fileFilter);

		//Using an anonymous class
		FileFilter fileFilter1 = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};

		final File[] javaFiles2 = dir.listFiles(fileFilter);

		//Lambda Expression

	}
}
