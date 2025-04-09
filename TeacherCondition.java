package pau.pau_zad3;

public enum TeacherCondition {
    PRESENT {
        public String toString() {
            return "present";
        }
    },
    DELEGATION {
        public String toString() {
            return "delegation";
        }
    },
    SICK {
        public String toString() {
            return "sick";
        }
    },
    ABSENT {
        public String toString() {
            return "absent";
        }
    }
}
