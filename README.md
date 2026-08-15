# SimolClient — starter source project

A Fabric mod scaffold in the style of Feather Client: custom title screen
branding + a "Mods" button, an account pill, a right-shift in-game menu, and
a small toggleable module system (FPS HUD, armor HUD, coords, keystrokes,
performance mode).

## What's actually here vs. what you still need to do

This is real, structured source — not a mockup — but it's a **starting
scaffold**, not a finished premium client. Treat it as the skeleton you build
the polish onto.

Still to do yourself:
- **Logo/icon**: drop a 128x128 `icon.png` (your cross logo) into
  `src/main/resources/assets/simolclient/`.
- **Custom panorama**: the current mixin leaves vanilla's animated panorama
  in place. To use your own, add a `PanoramaRenderer` that cycles your own
  background images/video frames, or ship a resource pack that overrides the
  vanilla `panorama_*.png` textures — the latter is far less mixin work.
- **Real skin head rendering** in `AccountWidget`: wire it to the actual
  player skin texture identifier (via `PlayerSkinProvider` / entity render
  state, depending on current mappings) instead of the gray placeholder box.
- **Exact button coordinates** in `TitleScreenMixin` — I estimated the "Mods"
  button position under Realms; nudge `x`/`y` once you see it in-game.
- **ClickGUI visual polish** — current version is a functional toggle list,
  not a styled panel. Add category tabs, drag-to-move, colors, animations.
- Fill in the **exact current values** in `gradle.properties`
  (`yarn_mappings`, `fabric_version`, `modmenu_version`) from
  https://fabricmc.net/develop — these change with every Minecraft release
  and I can't verify live values from here.

## Building it into SimolClient-V1.jar

You need a JDK 21 and internet access (Gradle needs to download Minecraft,
mappings, and Fabric API — this can't be done in a sandboxed environment,
which is why I can't hand you a compiled jar directly).

```bash
cd SimolClient
./gradlew build
```

The output jar lands in `build/libs/SimolClient-V1.jar` (see the `jar {}`
block in `build.gradle` — it's already named for you). Drop that into your
`.minecraft/mods` folder **alongside Fabric API and ModMenu** (both are
listed as dependencies), on Fabric Loader ≥0.19.3 for Minecraft 26.2.

## Project layout

```
src/main/java/net/simolclient/
  SimolClient.java            common entrypoint
  SimolClientClient.java      client entrypoint, right-shift keybind
  SimolConfig.java            persisted on/off state per module
  gui/ClickGuiScreen.java     the right-shift menu
  gui/AccountWidget.java      top-of-screen account pill
  module/                     module base class + registry
  module/impl/hud/            FPS, armor, coords, keystrokes
  module/impl/perf/           performance mode (real render-setting tweaks)
  mixin/                      TitleScreen, InGameHud, MinecraftClient hooks
  integration/                ModMenu API hookup
```

## On the "+20-30 FPS" ask

No mod can promise a fixed FPS number — gains depend entirely on the
player's hardware and current settings. `PerformanceModule` applies real,
well-known client-side cuts (particles, clouds, entity shadows, render
distance cap) that genuinely help on weaker machines without touching game
logic or giving any gameplay advantage. Don't hardcode marketing numbers
into the UI — measure actual before/after FPS per-user if you want to show a
number.
