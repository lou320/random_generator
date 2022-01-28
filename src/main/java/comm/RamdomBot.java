package comm;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RamdomBot extends TelegramLongPollingBot {
    RandomGenerator randomGenerator = new RandomGenerator();
    static String result;
    SendMessage error_respond = new SendMessage();
    SendMessage respond = new SendMessage();

    @Override
    public void onUpdateReceived(Update update) {
        respond.setChatId(update.getMessage().getChatId().toString());
        String[] arrayOfInput = update.getMessage().getText().split(" ");
        if (arrayOfInput[0].toString().equals("/run")) {
            result = randomGenerator.output();
            respond.setText(result);
        } else if (arrayOfInput[0].equals("/add")) {
            randomGenerator.add(arrayOfInput[1]);
            
            respond.setText("Added " + arrayOfInput[1]);
        } else if(arrayOfInput[0].equals("/remove")){
            randomGenerator.removeLastOne();
            respond.setText("Removed Last one.");
        } else if(arrayOfInput[0].equals("/clean")){
            randomGenerator.clean();
            respond.setText("List cleaned.");
        }
        try {
            execute(respond);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "random_geneBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "5030499524:AAF6wzSlpSJd5I-69tgOk8y1RykqCd-He7Y";
    }
}
