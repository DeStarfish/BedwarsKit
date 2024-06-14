




















public final class RelClickInvHelper {
    private static final String className = RelClickInvHelper.class.getSimpleName();

    public static boolean isBuyFail(boolean is2v2, Material clickedItemType, String gameName, String clickedItemName, Player player, String teamName, Matcher m_haste1, String replacement, Matcher m_fail, Matcher m_haste2, Matcher m_haste3, Matcher m_heal1, Matcher m_sharp1, Matcher m_sharp2, Matcher m_sharp3, Matcher m_sharp4, Matcher m_prot1, Matcher m_prot2, Matcher m_prot4, Matcher m_prot3, boolean is4v4) {
        boolean fail = true;
        if (isDebug()) {
            le(className, "[isBuyFail] clicking item type :" + clickedItemType);
        }

        if (is2v2) {

            if (clickedItemType == LevelConfigHandler.leveluphasteItemType) {

                HashMap<String, String> teamDatas = TeamHaste.getTeamDatas(gameName);
                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_haste1)
                            && isHaveDiamond(player, LevelConfigHandler.haste1Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2") && !Objects.equals(strings.getValue(), "1")) {
                            int count = LevelConfigHandler.haste1Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamHaste.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_haste1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        } else {
                            String mess = m_fail.replaceAll(replacement);
                            sendMessage(player, mess);
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_haste2)
                            && isHaveDiamond(player, LevelConfigHandler.haste2Cost2v2)) {

                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2")) {
                            int count = LevelConfigHandler.haste2Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "2");
                                TeamHaste.setTeamDatas(gameName, teamDatas);
                            }


                            String mess = m_haste2.replaceAll(replacement);

                            String s = t(mess);
                            sendMessage(player, s);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_haste3)
                            && isHaveDiamond(player, LevelConfigHandler.haste3Cost2v2)) {

                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "3")) {
                            int count = LevelConfigHandler.haste3Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "3");
                                TeamHaste.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_haste3.replaceAll(replacement);

                            String s = t(mess);
                            sendMessage(player, s);
                            fail = false;
                            break;
                        }
                    }
                }

            } else if (clickedItemType == LevelConfigHandler.leveluphealItemType) {

                HashMap<String, String> teamDatas = TeamHeal.getTeamDatas(gameName);

                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_heal1)
                            && isHaveDiamond(player, LevelConfigHandler.heal1Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "1")) {
                            int count = LevelConfigHandler.heal1Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamHeal.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_heal1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    }
                }
            } else if (clickedItemType == LevelConfigHandler.levelupsharpItemType) {

                HashMap<String, String> teamDatas = TeamSharp.getTeamDatas(gameName);

                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp1)
                            && isHaveDiamond(player, sharp1Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "1")
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp1Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_sharp1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp2)
                            && isHaveDiamond(player, sharp2Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp2Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "2");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_sharp2.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp3)
                            && isHaveDiamond(player, sharp3Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp3Cost2v2;


                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "3");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_sharp3.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp4)
                            && isHaveDiamond(player, sharp4Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp1Cost2v2;
                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "4");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_sharp4.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    }
                }
            } else if (clickedItemType == LevelConfigHandler.levelupprotItemType) {

                HashMap<String, String> teamDatas = TeamProtect.getTeamDatas(gameName);

                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot1)
                            && isHaveDiamond(player, prot1Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "1")
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot1Cost2v2;


                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_prot1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot2)
                            && isHaveDiamond(player, prot2Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot2Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "2");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_prot2.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot3)
                            && isHaveDiamond(player, prot3Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot3Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "3");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_prot4.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot4)
                            && isHaveDiamond(player, prot4Cost2v2)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot4Cost2v2;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "4");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_prot3.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    }
                }
            }

        } else if (is4v4) {

            if (clickedItemType == LevelConfigHandler.leveluphasteItemType) {

                HashMap<String, String> teamDatas = TeamHaste.getTeamDatas(gameName);
                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_haste1)
                            && isHaveDiamond(player, LevelConfigHandler.haste1Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2") && !Objects.equals(strings.getValue(), "1")) {
                            int count = LevelConfigHandler.haste1Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamHaste.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_haste1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        } else {
                            String mess = m_fail.replaceAll(replacement);
                            sendMessage(player, mess);
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_haste2)
                            && isHaveDiamond(player, LevelConfigHandler.haste2Cost4v4)) {

                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2")) {
                            int count = LevelConfigHandler.haste2Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "2");
                                TeamHaste.setTeamDatas(gameName, teamDatas);
                            }


                            String mess = m_haste2.replaceAll(replacement);

                            String s = t(mess);
                            sendMessage(player, s);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_haste3)
                            && isHaveDiamond(player, LevelConfigHandler.haste3Cost4v4)) {

                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "3")) {
                            int count = LevelConfigHandler.haste3Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "3");
                                TeamHaste.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_haste3.replaceAll(replacement);

                            String s = t(mess);
                            sendMessage(player, s);
                            fail = false;
                            break;
                        }
                    }
                }

            } else if (clickedItemType == LevelConfigHandler.leveluphealItemType) {

                HashMap<String, String> teamDatas = TeamHeal.getTeamDatas(gameName);

                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEffItemName_heal1)
                            && isHaveDiamond(player, LevelConfigHandler.heal1Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "1")) {
                            int count = LevelConfigHandler.heal1Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamHeal.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_heal1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    }
                }
            } else if (clickedItemType == LevelConfigHandler.levelupsharpItemType) {

                HashMap<String, String> teamDatas = TeamSharp.getTeamDatas(gameName);

                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp1)
                            && isHaveDiamond(player, sharp1Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "1")
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp1Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_sharp1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp2)
                            && isHaveDiamond(player, sharp2Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp2Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "2");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_sharp2.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp3)
                            && isHaveDiamond(player, sharp3Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp3Cost4v4;


                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "3");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_sharp3.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_sharp4)
                            && isHaveDiamond(player, sharp4Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = sharp1Cost4v4;
                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "4");
                                TeamSharp.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_sharp4.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    }
                }
            } else if (clickedItemType == LevelConfigHandler.levelupprotItemType) {

                HashMap<String, String> teamDatas = TeamProtect.getTeamDatas(gameName);

                for (Map.Entry<String, String> strings : teamDatas.entrySet()) {
                    if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot1)
                            && isHaveDiamond(player, prot1Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "1")
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot1Cost4v4;


                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "1");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }
                            String mess = m_prot1.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot2)
                            && isHaveDiamond(player, prot2Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "2")
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot2Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "2");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_prot2.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot3)
                            && isHaveDiamond(player, prot3Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "3")
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot3Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "3");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_prot4.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    } else if (Objects.equals(clickedItemName, LevelConfigHandler.teamEnchItemName_prot4)
                            && isHaveDiamond(player, prot4Cost4v4)) {
                        if (Objects.equals(strings.getKey(), teamName)
                                && !Objects.equals(strings.getValue(), "4")) {
                            int count = prot4Cost4v4;

                            if (isRemovedDiamond(player, count)) {
                                teamDatas.put(teamName, "4");
                                TeamProtect.setTeamDatas(gameName, teamDatas);
                            }

                            String mess = m_prot3.replaceAll(replacement);
                            sendMessage(player, mess);
                            fail = false;
                            break;
                        }
                    }
                }
            }

        }
        return fail;
    }
}

