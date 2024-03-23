package Extras;

public class SingletonDemo {

    class TheSingleton {
        private static TheSingleton ins = null;

        private TheSingleton() {
        }

        public TheSingleton getIns() {
            if (ins == null) {
                synchronized (TheSingleton.class) {
                    if (ins == null) {
                        ins = new TheSingleton();
                    }
                }
            }
            return ins;
        }
    }
}
