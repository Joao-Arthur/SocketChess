package Chess.Lobby.Observers;

import Chess.Events.Observer;
import Chess.GUI.GUI;
import Chess.Lobby.Services.CreateMatchMessageService;
import Chess.Match.MatchScreen;
import Chess.Match.Services.GetPlayerByOpponentService;

public class CreateMatch implements Observer {
    public void handle(String event) {
        if (!event.startsWith(CreateMatchMessageService.PREFIX))
            return;
        GUI.getInstance().goTo(new MatchScreen(
                GetPlayerByOpponentService.get(
                        CreateMatchMessageService.decode(event))));
    }
}