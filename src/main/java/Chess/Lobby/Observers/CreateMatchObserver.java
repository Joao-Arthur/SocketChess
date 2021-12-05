package Chess.Lobby.Observers;

import Chess.Events.Observer;
import Chess.GUI.GUI;
import Chess.Lobby.Services.CreateMatchMessageService;
import Chess.Match.MatchScreen;

public class CreateMatchObserver implements Observer {
    public void handle(String event) {
        if (!event.startsWith(CreateMatchMessageService.PREFIX))
            return;
        GUI.getInstance().goTo(new MatchScreen(CreateMatchMessageService.decode(event)));
    }
}