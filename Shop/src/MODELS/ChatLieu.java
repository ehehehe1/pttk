package MODELS;

public class ChatLieu {
    private int idChatLieu;
    private String chatLieu;

    public ChatLieu() {
    }

    public ChatLieu(int idChatLieu, String chatLieu) {
        this.idChatLieu = idChatLieu;
        this.chatLieu = chatLieu;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    @Override
    public String toString() {
        return chatLieu;
    }
    
}
