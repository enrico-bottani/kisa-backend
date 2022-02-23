package kisa.team.exercisesservice.model.todo;

public enum TodoType {
    RC_SENTENCE_TYPE("RCT"), TODO("GEN");;
    private final String text;

    /**
     * @param text
     */
    TodoType(final String text) {
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
