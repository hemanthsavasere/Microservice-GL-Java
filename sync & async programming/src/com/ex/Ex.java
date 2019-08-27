package com.ex;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

//----------------------------------------------------
// producer / dependency / e.g Trainer
//----------------------------------------------------

class Trainer {
	public String getSingleSubject() {
		// compute...
		return "sub-1";
	}

	public Iterator<String> getMultipleSubjects() {

		return new Iterator<String>() {
			int idx = 0;

			@Override
			public boolean hasNext() {
				return idx <= 5 ? true : false;
			}

			@Override
			public String next() {
				idx++;
				return "sub-" + idx;
			}
		};
	}

	public Future<String> getSingleSubjectAsync() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> task = () -> {
			return "sub-1"; // push
		};
		return executorService.submit(task);
	}

	public Observable<String> getMultipleSubjectsAsync() {
		return Observable.create(emitter -> {
			new Thread(() -> {
				try {
					emitter.onNext("sub-1");
					TimeUnit.SECONDS.sleep(1);
					emitter.onNext("sub-2");
					TimeUnit.SECONDS.sleep(1);
					emitter.onNext("sub-2");
					TimeUnit.SECONDS.sleep(1);
					emitter.onNext("sub-3");
					TimeUnit.SECONDS.sleep(1);
					emitter.onNext("sub-4");
					TimeUnit.SECONDS.sleep(1);
					emitter.onNext("sub-5");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();

		});
	}

}

//----------------------------------------------------
//consumer / dependency / e.g Participant
//----------------------------------------------------

class Participant {

	Trainer trainer = new Trainer();

	public void doLearnAndWork() {

		// #1
//		String sub1 = trainer.getSingleSubject(); // pull / sync / blocking-call
//		System.out.println("==> " + sub1);

		// #2
//		Iterator<String> iterator = trainer.getMultipleSubjects();
//		while (iterator.hasNext()) {
//			String sub = iterator.next(); // pull / sync / blocking-call
//			System.out.println(sub);
//		}

		// #3
//		Future<String> future = trainer.getSingleSubjectAsync();
//		try {
//			String sub1 = future.get();
//			System.out.println(sub1);
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}

		Observable<String> stream = trainer.getMultipleSubjectsAsync();
		stream
		.subscribe(next -> {
			System.out.println("==>" + next);
		}, error -> {
			System.out.println("==>" + error);
		}, () -> {
			System.out.println("thansk for all subjects..so far");
		});

		System.out.println("participant moving to do other work..");

	}
}

public class Ex {

	public static void main(String[] args) {

		Participant participant = new Participant();
		participant.doLearnAndWork();

	}

}
