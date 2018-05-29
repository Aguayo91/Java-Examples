package com.studytrails.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CreatingCompletableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

	}

	@Test
	public void chainMethods() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			return "Process 1";
		});
		CompletableFuture<String> otherCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Process 2";
		});

		// If there are two CompletableFutures and we need to perform an action with the
		// first action that completes, then use acceptEither. Has an async variation.
		completableFuture.acceptEither(otherCompletableFuture, (s) -> {
			System.out.println(s); // prints "Process 1"
		});

		// the apply variation performs an operation on the result and returns the
		// result of that operation.
		System.out.println(completableFuture.applyToEither(otherCompletableFuture, (s) -> {
			return s.toLowerCase();
		}).get()); // print "process 1"

		// to handle the results and completion exception both, use the handle method.
		// Has an async version too.
		CompletableFuture<String> stage1 = completableFuture.handle((s, e) -> {
			if (e != null)
				System.out.println(e.getMessage());
			return s.toLowerCase();
		});
		System.out.println(stage1.get()); // prints process1

	}

	@Test
	public void testRunAfterBoth() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
			System.out.println("Process 1");
		});
		CompletableFuture<Void> otherCompletableFuture = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Process 2");
		});
		// use the runAfterBoth method to execute a Runnable after execution of two
		// CompletableFutures
		completableFuture.runAfterBoth(otherCompletableFuture, () -> {
			System.out.println("After process 1 and process 2");
		}).get(); // prints "Process 1" followed by "Process 2" and then "After process 1 and
		// process 2"
	}

	@Test
	public void testrunThenAccept() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			return "Process 1";
		});
		CompletableFuture<String> otherCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Process 2";
		});
		// use the runAfterBoth method to execute a Runnable after execution of two
		// CompletableFutures
		completableFuture.thenAcceptBoth(otherCompletableFuture, (s1, s2) -> {
			System.out.println("result of 1 : " + s1);
			System.out.println("result of 2 : " + s2);
			System.out.println("After process 1 and process 2");
		}).get();
		/*-
		 * prints
		 * result of 1 : Process 1
		   result of 2 : Process 2
		   After process 1 and process 2
		 */

	}

	@Test
	public void testAnyOf() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			return "Process 1";
		});
		CompletableFuture<String> otherCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Process 2";
		});
		// returns a completablefuture when any one of the two completes
		System.out.println(CompletableFuture.anyOf(completableFuture, otherCompletableFuture).get());// prints Process 1

	}

	@Test
	public void testAllOf() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			return "Process 1";
		});
		CompletableFuture<String> otherCompletableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Process 2";
		});
		// returns a completablefuture when any one of the two completes. This method
		// can be used to wait for all completablefutures to complete. No results are
		// returned
		System.out.println(CompletableFuture.allOf(completableFuture, otherCompletableFuture).get()); // prints null

	}

	@Test
	public void completionMethods() {
		// Lets see how to explicitly complete the CompletableFuture

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			return "finished";
		});
		// complete it
		completableFuture.complete(null);
		try {
			// prints a null
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// no exception thrown
			e.printStackTrace();
		}
		System.out.println(completableFuture.isDone());// prints true

		System.out.println("------ Exception -----------");

		CompletableFuture<String> completableFutureException = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			return "finished";
		});

		completableFutureException.completeExceptionally(new Exception("Explicitly Completed"));
		try {
			System.out.println(completableFutureException.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage()); // prints java.lang.Exception: Explicitly Completed
		}
		System.out.println(completableFutureException.isCancelled());// prints false
		System.out.println(completableFutureException.isCompletedExceptionally());// prints true

		System.out.println("----- Complete -------");
		CompletableFuture<String> completableFutureCompleteExplicitly = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			return "finished";
		});

		completableFutureCompleteExplicitly.complete("Explicitly Finished");
		try {
			System.out.println(completableFutureCompleteExplicitly.get());// prints "Explicitly Finished"
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage()); // nothing printed
		}
		System.out.println(completableFutureCompleteExplicitly.isCancelled());// prints false

	}

	@Test
	public void creationMethods() throws InterruptedException, ExecutionException {
		// create an empty CompletableFuture and add stages to it. It is incomplete and
		// can be completed.
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		// create a completableFuture Using a Supplier<U>. The supplier provides the
		// return value and the completablefuture is asynchronously completed.
		CompletableFuture<String> completableFutureSupplyAsync = CompletableFuture.supplyAsync(() -> {
			return Thread.currentThread().getName();
		});
		System.out.println(completableFutureSupplyAsync.get());// Prints ForkJoinPool.commonPool-worker-1
		// By Default the async process uses the ForkJoinPool, however we can pass our
		// own Executor framework.

		Executor executor = Executors.newCachedThreadPool();
		CompletableFuture<String> completetableFutureSupplyAsyncWithCustomExecutor = CompletableFuture
				.supplyAsync(() -> {
					return Thread.currentThread().getName();
				}, executor);
		System.out.println(completetableFutureSupplyAsyncWithCustomExecutor.get());// prints pool-1-thread-1

		// if you don't need to return a value, use the runAsync method instead. It
		// takes in a Runnable
		CompletableFuture<Void> completetableFutureRunAsync = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName());
		});
	}
}
