package topic21_threads;

/**
 * ============================================================================
 * TOPIC 21: JAVA THREADS & MULTITHREADING (PARALLEL EXECUTION)
 * ============================================================================
 * 
 * 📌 THREAD KYA HOTA HAI?
 * - Thread ek program ka sabse chhota "Independent Path of Execution" hota hai.
 * - Multi-threading ka matlab: Ek hi samay par ek sath MULTIPLE KAAM (Parallel execution) karna!
 * - Real Example: Video download ho rahi hai aur sath me music bhi play ho raha hai.
 * 
 * 📌 THREAD BANANE KE 2 TARIQE:
 * 1. Extending `Thread` Class
 * 2. Implementing `Runnable` Interface (Recommended - Best Practice!)
 * 
 * 📌 'start()' VS 'run()' KA FARQ (INTERVIEW FAVORITE!):
 * - `thread.start()` : Naya alag thread spawn/create karta hai aur uspar parallel run() chalata hai.
 * - `thread.run()`   : Naya thread NAHI banata, balki main thread par normal method ki tarah chal jata hai!
 */

// ----------------------------------------------------------------------------
// METHOD 1: Extending Thread Class
// ----------------------------------------------------------------------------
class DownloadTask extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("⬇️ Downloading File: " + (i * 33) + "% complete (Thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(500); // 500 milliseconds (0.5 second) pause
            } catch (InterruptedException e) {
                System.out.println("Download interrupted");
            }
        }
        System.out.println("✅ Download Completed!");
    }
}

// ----------------------------------------------------------------------------
// METHOD 2: Implementing Runnable Interface (Best Practice)
// ----------------------------------------------------------------------------
class MusicPlayerTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("🎵 Playing Music Track " + i + " (Thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Music interrupted");
            }
        }
        System.out.println("🎶 Music Playlist Finished!");
    }
}

// ----------------------------------------------------------------------------
// SYNCHRONIZATION DEMO (Race Condition Prevention)
// ----------------------------------------------------------------------------
class Counter {
    private int count = 0;

    // 🔹 'synchronized' keyword: Ek samay par sirf 1 hi thread is method me ghus sakta hai!
    // Isse race condition aur data corruption nahi hoti.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// ----------------------------------------------------------------------------
// MAIN DEMO
// ----------------------------------------------------------------------------
public class ThreadsDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================");
        System.out.println("      TOPIC 21: JAVA THREADS COMPLETE DEMO        ");
        System.out.println("==================================================\n");

        // 🔹 1. RUNNING PARALLEL THREADS
        System.out.println("--- 1. Starting Parallel Threads ---");
        DownloadTask downloadThread = new DownloadTask();
        downloadThread.setName("DownloaderThread");

        Thread musicThread = new Thread(new MusicPlayerTask(), "MusicThread");

        // start() se dono threads PARALLEL me ek sath start ho jayenge!
        downloadThread.start();
        musicThread.start();

        // 🔹 join(): Main thread ko bolta hai ki jab tak ye dono threads apna kaam 
        // khatam na kar lein, tab tak aage mat badho (Wait karo).
        downloadThread.join();
        musicThread.join();
        System.out.println();

        // 🔹 2. SYNCHRONIZATION DEMO (Thread Safety)
        System.out.println("--- 2. Thread Synchronization (Thread-Safe Counter) ---");
        Counter counter = new Counter();

        // 2 alag threads bana rahe hain jo same counter ko 1000-1000 baar increment karenge:
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total Counter Value (Expected 2000): " + counter.getCount() + " (Thread-Safe!)");

        System.out.println("\n==================================================");
        System.out.println("           THREADS DEMO COMPLETED!                ");
        System.out.println("==================================================");
    }
}
