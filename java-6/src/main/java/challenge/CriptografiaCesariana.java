package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        Validation(texto);
        String lowercaseCipher = ToLowerCase(texto);
        String cipher = Crypted(lowercaseCipher);
        return cipher;
    }

        @Override
        public String descriptografar (String texto){
            Validation(texto);
            String lowercaseCipher = texto.toLowerCase();
            String decrypted = Decrypted(lowercaseCipher);
            return decrypted;
        }

        public String ToLowerCase (String text) {
            return text.toLowerCase();
        }


        public String Decrypted(String text){
            StringBuilder decrypted = new StringBuilder();
            int shift = 3;
            try {
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    int parameter = (int) c;
                    if (parameter == 32 || parameter == 44 || parameter == 46 ||
                            (parameter <= 57 && parameter >= 48)) {
                        char rightChar = (char) parameter;
                        decrypted.append(rightChar);
                    } else {
                        parameter = parameter - shift;
                        if (parameter < 97) {
                            int difference = 97 - parameter;
                            parameter = 123 - difference;
                            char rightChar = (char) parameter;
                            decrypted.append(rightChar);
                        } else {
                            char rightChar = (char) parameter;
                            decrypted.append(rightChar);
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return decrypted.toString();
        }


        public String Crypted(String text){
            StringBuilder crypted = new StringBuilder();
            int shift = 3;
            try {
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    int parameter = (int) c;
                    if (parameter == 32 || parameter == 44 || parameter == 46 ||
                            (parameter <= 57 && parameter >= 48)) {
                        char rightChar = (char) parameter;
                        crypted.append(rightChar);
                    } else {
                        parameter = parameter + shift;
                        if (parameter > 122) {
                            int difference = parameter - 122;
                            parameter = 96 + difference;
                            char rightChar = (char) parameter;
                            crypted.append(rightChar);
                        } else {
                            char rightChar = (char) parameter;
                            crypted.append(rightChar);
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return crypted.toString();
        }


        public void Validation(String text){
            if(text == null){
                throw new NullPointerException("Text is Null");
            }
            if(text.isEmpty()){
                throw new IllegalArgumentException("Text is Empty");
            }
        }
}
