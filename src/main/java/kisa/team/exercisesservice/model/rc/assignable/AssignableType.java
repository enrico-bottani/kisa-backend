package kisa.team.exercisesservice.model.rc.assignable;

public enum AssignableType {
        RC_ANSWERABLE("RCA"), STRING("STR"),Undefined("UND");;
        private final String text;

        /**
         * @param text
         */
        AssignableType(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
}
