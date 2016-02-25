package com.kildeen.heloderma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pinger {
	private static Logger log = LoggerFactory.getLogger(Pinger.class);
	private static String processName;

	public static void main(String[] args) {

		if (args == null || args.length == 0) {
			log.warn("No process detected");
		} else {
			processName = args[0];
			log.info("Montering started, process name: {}", processName);
			while (true) {
				boolean processActive = false;

				ProcessBuilder pb = new ProcessBuilder("tasklist");
				pb.redirectErrorStream(true);
				Process process;
				try {
					process = pb.start();

					BufferedReader reader = new BufferedReader(
							new InputStreamReader(process.getInputStream()));
					String line;
					while ((line = reader.readLine()) != null) {
						if (line.contains(processName)) {
							processActive = true;
							log.info("Process detected: {}", processName);

							break;
						}
					}

					if (processActive == false) {
						log.error("Could not detect process: {}", processName);
					}
					process.waitFor();
					Thread.sleep(3000L);
				} catch (IOException | InterruptedException e) {

				}
			}

		}
	}
}
