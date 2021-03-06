package io.pivotal.microservices.services;

import io.pivotal.microservices.services.accounts.AccountsServer;
import io.pivotal.microservices.services.registration.RegistrationServer;
import io.pivotal.microservices.services.web.WebServer;

/**
 * 
 * 
 * @author Govind Raju
 */
public class Main {

	public static void main(String[] args) {

		String serverName = "NO-VALUE";

		switch (args.length) {
		case 2:
			
			System.setProperty("server.port", args[1]);
			// Fall through into ..

		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			usage();
			return;
		}

		if (serverName.equals("registration") || serverName.equals("reg")) {
			RegistrationServer.main(args);
		} else if (serverName.equals("accounts")) {
			AccountsServer.main(args);
		} else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
			usage();
		}
	}

	protected static void usage() {
		System.out.println("Usage: java -jar ... ");
		System.out.println(
				"     where server-name is 'reg', 'registration', " + "'accounts' or 'web' and server-port ");
	}
}
