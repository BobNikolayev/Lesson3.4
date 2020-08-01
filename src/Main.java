public class Main {
    static final Object monitor = new Object();
    static volatile int letterNum = 1;
    static int cycleNum = 5;

    public static void main(String[] args) {
// НЕУДАЧНАЯ ПОПЫТКА
//       //letter A
//        new Thread(()->{
//            for (int i = 0; i < cycleNum; i++) {
//                try{
//                synchronized (monitor){
//                    if (letterNum == 1){
//                        System.out.print("A");
//                        letterNum = 2;
//                        monitor.notifyAll();
//                    }else {
//                        try {
//                            monitor.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        }).start();
//
////letter B
//        new Thread(()->{
//            for (int i = 0; i < cycleNum; i++) {
//                try{
//                synchronized (monitor){
//                    if (letterNum == 2){
//                        System.out.print("B");
//                        letterNum = 3;
//                        monitor.notifyAll();
//                    }else {
//                        try {
//                            monitor.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        }).start();
////letter C
//        new Thread(()->{
//            for (int i = 0; i < cycleNum; i++) {
//                try{
//                synchronized (monitor){
//                    if (letterNum == 3){
//                        System.out.print("C");
//                        letterNum = 1;
//                        monitor.notifyAll();
//                    }else {
//                        try {
//                            monitor.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        }).start();


        //letter A
        new Thread(()->{
            for (int i = 0; i < cycleNum; i++) {
                try{
                synchronized (monitor){
                    while (letterNum != 1){
                        monitor.wait();
                    }

                    System.out.print("A");
                    letterNum = 2;
                    monitor.notifyAll();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        }).start();

//letter B
        new Thread(()->{
            for (int i = 0; i < cycleNum; i++) {
                try{
                    synchronized (monitor){
                        while (letterNum != 2){
                            monitor.wait();
                        }

                        System.out.print("B");
                        letterNum = 3;
                        monitor.notifyAll();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
//letter C
        new Thread(()->{
            for (int i = 0; i < cycleNum; i++) {
                try{
                    synchronized (monitor){
                        while (letterNum != 3){
                            monitor.wait();
                        }

                        System.out.print("C");
                        letterNum = 1;
                        monitor.notifyAll();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
