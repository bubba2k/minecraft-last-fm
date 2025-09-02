
## fm-plugin - Last.fm integration for Minecraft

A PaperMC plugin to query last.fm and let your fellow players know what you are listening to.


![Ingame output of a few /fm calls](https://github.com/bubba2k/minecraft-last-fm/blob/main/screenshot.png)

### Setup

#### 1. Install
Grab the latest jar from the releases tab on the right and drop it in your PaperMC servers plugin directory.
Restart the server once to initialize the default config file.

#### 2. Supply the API key
Apply for a last.fm API key here: https://www.last.fm/api/account/create.

Fear not, it is not difficult and, in my experience, they are lenient. Just explain you are using it for last.fm 
integration for your Minecraft server and point to this plugin. 
You can ignore the "Callback URL" field.

Once you have your key, open `plugins/fm/config.yml` and add it there as instructed.
Restart the server and you are good to go!

### Usage

| Command                    | Description                                |
|----------------------------|--------------------------------------------|
| `/fmset <lastfm username>` | Set your last.fm username                  |
| `/fm`                      | Display your current/last scrobble in chat |
| `/fmhelp`                  | Display help text                          |
