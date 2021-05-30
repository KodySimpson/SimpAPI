package me.kodysimpson.simpapi.colors;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;

public class ColorTranslator {

    @NotNull
    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    /**
     * @param text The string of text to apply color/effects to
     * @return Returns a string of text with color/effects applied
     */
    @NotNull
    public static String translateColorCodes(@NotNull String text){

        String[] texts = text.split(String.format(WITH_DELIMITER, "&"));

        StringBuilder finalText = new StringBuilder();

        for (int i = 0; i < texts.length; i++){
            if (texts[i].equalsIgnoreCase("&")){
                //get the next string
                i++;
                if (texts[i].charAt(0) == '#'){
                    finalText.append(ChatColor.of(texts[i].substring(0, 7)) + texts[i].substring(7));
                }else{
                    finalText.append(ChatColor.translateAlternateColorCodes('&', "&" + texts[i]));
                }
            }else{
                finalText.append(texts[i]);
            }
        }

        return finalText.toString();
    }

    @NotNull
    public static TextComponent translateColorCodesToTextComponent(@NotNull String text){

        String[] texts = text.split(String.format(WITH_DELIMITER, "&"));

        ComponentBuilder builder = new ComponentBuilder();

        for (int i = 0; i < texts.length; i++){
            TextComponent subComponent = new TextComponent();
            if (texts[i].equalsIgnoreCase("&")){
                //get the next string
                i++;
                if (texts[i].charAt(0) == '#'){
                    subComponent.setText(texts[i].substring(7));
                    subComponent.setColor(net.md_5.bungee.api.ChatColor.of(texts[i].substring(0, 7)));
                    builder.append(subComponent);
                }else{
                    if (texts[i].length() > 1){
                        subComponent.setText(texts[i].substring(1));
                    }else{
                        subComponent.setText(" ");
                    }

                    switch (texts[i].charAt(0)){
                        case '0':
                            subComponent.setColor(ChatColor.BLACK);
                            break;
                        case '1':
                            subComponent.setColor(ChatColor.DARK_BLUE);
                            break;
                        case '2':
                            subComponent.setColor(ChatColor.DARK_GREEN);
                            break;
                        case '3':
                            subComponent.setColor(ChatColor.DARK_AQUA);
                            break;
                        case '4':
                            subComponent.setColor(ChatColor.DARK_RED);
                            break;
                        case '5':
                            subComponent.setColor(ChatColor.DARK_PURPLE);
                            break;
                        case '6':
                            subComponent.setColor(ChatColor.GOLD);
                            break;
                        case '7':
                            subComponent.setColor(ChatColor.GRAY);
                            break;
                        case '8':
                            subComponent.setColor(ChatColor.DARK_GRAY);
                            break;
                        case '9':
                            subComponent.setColor(ChatColor.BLUE);
                            break;
                        case 'a':
                            subComponent.setColor(ChatColor.GREEN);
                            break;
                        case 'b':
                            subComponent.setColor(ChatColor.AQUA);
                            break;
                        case 'c':
                            subComponent.setColor(ChatColor.RED);
                            break;
                        case 'd':
                            subComponent.setColor(ChatColor.LIGHT_PURPLE);
                            break;
                        case 'e':
                            subComponent.setColor(ChatColor.YELLOW);
                            break;
                        case 'f':
                            subComponent.setColor(ChatColor.WHITE);
                            break;
                        case 'k':
                            subComponent.setObfuscated(true);
                            break;
                        case 'l':
                            subComponent.setBold(true);
                            break;
                        case 'm':
                            subComponent.setStrikethrough(true);
                            break;
                        case 'n':
                            subComponent.setUnderlined(true);
                            break;
                        case 'o':
                            subComponent.setItalic(true);
                            break;
                        case 'r':
                            subComponent.setColor(ChatColor.RESET);
                            break;
                    }

                    builder.append(subComponent);
                }
            }else{
                builder.append(texts[i]);
            }
        }

        return new TextComponent(builder.create());

    }


}
