package app.server.utils;

import app.server.domain.Language;

import java.io.Serializable;

public class TranslateQueryData implements Serializable {

    private Language from;
    private Language to;

    public Language getFrom() {
        return from;
    }

    public void setFrom(Language from) {
        this.from = from;
    }

    public Language getTo() {
        return to;
    }

    public void setTo(Language to) {
        this.to = to;
    }
}
