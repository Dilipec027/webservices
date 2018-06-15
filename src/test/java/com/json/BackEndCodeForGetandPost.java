package com.json;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;
import org.json.XML;

public class BackEndCodeForGetandPost {

	public void json() {
		JSONObject json = new JSONObject();
		json.put("grant_type", "password");
		json.put("password", "check");
		json.put("username", "DMUHBR");
		String xml = XML.toString(json);
		System.out.println(json);
		System.out.println(xml);
	}

	public void certificateAccept() throws Exception {
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		SSLContext.setDefault(ctx);
	}

	public String sendGet(String url, List<String> values) throws Exception {
		System.out.println("Inside the sendGET method");
		System.out.println(url);

		// configure the SSLContext with a TrustManager
		certificateAccept();

		// String url = "https://acctcs.scania.com/api/auth/oauth/token";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuquest header
		con.setRequestMethod("GET");

		System.out.println(values);
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
			con.setRequestProperty(values.get(i), values.get(i + 1));
			i = i + 1;
		}

		System.out.println("Code is before the data write");
		System.out.println(con);

		System.out.println("Code is after the data write");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Header content :" + con);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		return response.toString();
	}
	// public String sendGet(String url) throws Exception {
	//
	// // configure the SSLContext with a TrustManager
	//
	// certificateAccept();
	//// String url ="https://acctcs.scania.com";
	// URL obj = new URL(url);
	// HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	//
	// // optional default is GET
	// con.setRequestMethod("GET");
	//
	// // add request header
	//
	// int responseCode = con.getResponseCode();
	// System.out.println("\nSending 'GET' request to URL : " + url);
	// System.out.println("Response Code : " + responseCode);
	//
	// BufferedReader in = new BufferedReader(new
	// InputStreamReader(con.getInputStream()));
	// String inputLine;
	// StringBuffer response = new StringBuffer();
	//
	// while ((inputLine = in.readLine()) != null) {
	// response.append(inputLine);
	// }
	// in.close();
	//
	// // print result
	// System.out.println(response.toString());
	// return (response.toString());
	// }

	// HTTP POST request
	public String sendPost(String url, List<String> values, String testdata) throws Exception {
		System.out.println("Inside the sendpost method");
		System.out.println(url);

		// configure the SSLContext with a TrustManager
		certificateAccept();

		// String url = "https://acctcs.scania.com/api/auth/oauth/token";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// for https conncetion only this works
		// HttpsURLConnection con1 = (HttpsURLConnection) obj.openConnection();

		// add reuquest header
		con.setRequestMethod("POST");
		// con.setRequestProperty("Accept", "application/json, text/plain, */*");
		// con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		// con.setRequestProperty("authorization", "Basic dGNzdGF0dXM6dGNzdGF0dXM=");
		// con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		System.out.println(values);
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
			con.setRequestProperty(values.get(i), values.get(i + 1));
			i = i + 1;
		}
		System.out.println("Code is before the data write");
		System.out.println(con);
		// String url1 = "password=Boy@2729&grant_type=password&username=DMUHBR";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(testdata);
		wr.flush();
		wr.close();
		System.out.println("Code is after the data write");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + testdata);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Header content :" + con);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		return response.toString();
	}

	// To accept the certification in SSL layer
	private static class DefaultTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

}
