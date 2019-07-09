@echo on
@echo =============================================================
@echo $                                                           $
@echo $                     Ratel Aries                     $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Aries Studio All Right Reserved                        $
@echo $  Copyright (C) 2017-2050                                  $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title Ratel Aries
@color 0a

call mvn  javadoc:jar clean deploy -DskipTests -e -P release -pl aries-start-server,aries-start-zuul -am -Dmaven.javadoc.skip=true

pause