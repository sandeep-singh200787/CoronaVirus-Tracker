package com.covid19.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.covid19.model.LocationStats;

@Service
public class CoronaService {

	
	private static String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/03-14-2020.csv";
	
	private List<LocationStats> allStats = new ArrayList<LocationStats>();
	
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
		List<LocationStats> localStats = new ArrayList<LocationStats>();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
							  .uri(URI.create(url))
							  .build();
		
		
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader reader = new StringReader(response.body());		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		for (CSVRecord record : records) {
			LocationStats stats = new LocationStats();
			stats.setState(record.get("Province/State"));
			stats.setCountry(record.get("Country/Region"));
			stats.setConfirmedCases(Integer.parseInt(record.get("Confirmed")));
			stats.setDeaths(Integer.parseInt(record.get("Deaths")));
			stats.setRecovered(Integer.parseInt(record.get("Recovered")));
			localStats.add(stats);
		}
		
		this.allStats = localStats;
		
	}

	public List<LocationStats> getAllStats() {
		return allStats;
	}

	public void setAllStats(List<LocationStats> allStats) {
		this.allStats = allStats;
	}
	
	
}
