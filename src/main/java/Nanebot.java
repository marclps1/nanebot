import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Nanebot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

     //   System.out.println(update.getMessage().getText());
     //   System.out.println(update.getMessage().getFrom().getFirstName());



        String command=update.getMessage().getText();
        String animationurl = "https://media.giphy.com/media/gFYt7JTzRp22k/giphy.gif";

        SendMessage message = new SendMessage();
        SendAnimation animation = new SendAnimation();
        SendVideo vid = new SendVideo();


        if(command.equals("+bater")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            vid.setVideo(animationurl);
        }
        message.setChatId(update.getMessage().getChatId());
        vid.setChatId(update.getMessage().getChatId());

        try {
            execute(vid);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "naneramalhobot";
    }

    @Override
    public String getBotToken() {
        return "831580269:AAHvMKaCghTMFECKQU2x89xxhXfzF_xvzb4";
    }
}
