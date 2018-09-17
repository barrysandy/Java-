package com.xgb.org.chapter3.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FightQueryExample {
	
	private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");
	
	public static void main(String[] args) {
		List<String> results = search("SH","BJ");
		System.out.println("====================result==============");
		results.forEach(System.out::println);
	}

	private static List<String> search(String original, String dest) {
			final List<String> result = new ArrayList<>();
			List<FightQueryTask> tasks = new ArrayList<>();
			for (int i = 0; i < fightCompany.size(); i++) {
				FightQueryTask queryTask = createSearchTask(fightCompany.get(i),original, dest);
				tasks.add(queryTask);
			}
			
			tasks.forEach(Thread::start);
			tasks.forEach(t ->
			{
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			tasks.stream().map(FightQuery::get).forEach(result::addAll);
		return result;
	}
	
	
	private static FightQueryTask createSearchTask(String fight,String original,String dest) {
		return new FightQueryTask(fight,original,dest);
	}

}
