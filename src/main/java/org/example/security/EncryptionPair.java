package org.example.security;

public final class EncryptionPair {

    private final String text;
    private final String preparedKey;

    public EncryptionPair(Builder builder) {
        this.preparedKey = builder.preparedKey;
        this.text = builder.text;
    }

    public String getText() {
        return text;
    }

    public String getPreparedKey() {
        return preparedKey;
    }

    public static class Builder {

        private String text;
        private final String preparedKey;

        public Builder(String preparedKey) {
            this.preparedKey = preparedKey;
        }

        public Builder withText(String cipherText) {
            this.text = cipherText;

            return this;
        }

        public EncryptionPair build() {
            return new EncryptionPair(this);
        }
    }
}
